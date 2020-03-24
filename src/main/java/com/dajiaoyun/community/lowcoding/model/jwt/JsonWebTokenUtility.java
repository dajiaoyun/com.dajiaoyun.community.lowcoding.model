package com.dajiaoyun.community.lowcoding.model.jwt;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;

import com.dajiaoyun.community.lowcoding.model.date.FlexDate;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JsonWebTokenUtility {
	private SignatureAlgorithm signatureAlgorithm;
	private Key secretKey;

	public JsonWebTokenUtility() {

		// THIS IS NOT A SECURE PRACTICE!
		// For simplicity, we are storing a static key here.
		// Ideally, in a microservices environment, this key would kept on a
		// config server.
		signatureAlgorithm = SignatureAlgorithm.HS512;
		String encodedKey = "L7A/6zARSkK1j7Vd5SFF9pSSqZlqF7mAhiOgRbgv9Smce6rf4cJbbyyKOjtKPxNNnWQj+2lQEScm3XjhW+YVZg==";
		secretKey = deserializeKey(encodedKey);

		// secretKey = MacProvider.generateKey(signatureAlgorithm);
	}

	public String createJsonWebToken(AuthTokenDetailsDTO authTokenDetailsDTO) {
		String token = Jwts.builder().setSubject(authTokenDetailsDTO.userId).claim("password", authTokenDetailsDTO.password)
				.claim("username", authTokenDetailsDTO.userName)
				.claim("tenantno", authTokenDetailsDTO.tenantno).claim("from", authTokenDetailsDTO.from)
				.claim("roles", authTokenDetailsDTO.roles)	
//				.claim("menus", authTokenDetailsDTO.menus)
				.setExpiration(authTokenDetailsDTO.expirationDate)
				.signWith(getSignatureAlgorithm(), getSecretKey()).compact();
		return token;
	}

	private Key deserializeKey(String encodedKey) {
		byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
		Key key = new SecretKeySpec(decodedKey, getSignatureAlgorithm().getJcaName());
		return key;
	}

	private Key getSecretKey() {
		return secretKey;
	}

	public SignatureAlgorithm getSignatureAlgorithm() {
		return signatureAlgorithm;
	}

	public AuthTokenDetailsDTO parseAndValidate(String token) {
		AuthTokenDetailsDTO authTokenDetailsDTO = null;
		try {
			//Bearer 
			token=token.replace("Bearer", "");
			token=token.trim();
			Claims claims = Jwts.parser().setSigningKey(getSecretKey()).parseClaimsJws(token).getBody();
			String userId = claims.getSubject();
			String tenantno = (String) claims.get("tenantno");
			String password=(String) claims.get("password");
			String from=(String) claims.get("from");
			String userName=(String) claims.get("username");
			List<String> roles = (List<String>) claims.get("roles");
//			List<Menu> menus = (List<Menu>) claims.get("menus");
			Date expirationDate = claims.getExpiration();
			String date1=FlexDate.getFullDate();
			String date2=FlexDate.getFullDate(expirationDate);
			if(!from.equalsIgnoreCase("web")){
				if(FlexDate.before(date1, date2)){
					authTokenDetailsDTO = new AuthTokenDetailsDTO();
					authTokenDetailsDTO.userId = userId;
					authTokenDetailsDTO.password=password;
					authTokenDetailsDTO.tenantno = tenantno;
					authTokenDetailsDTO.roles = roles;
					authTokenDetailsDTO.from=from;
					authTokenDetailsDTO.userName=userName;
//					authTokenDetailsDTO.menus = menus;
					authTokenDetailsDTO.expirationDate = expirationDate;
				}
			}else{
				authTokenDetailsDTO = new AuthTokenDetailsDTO();
				authTokenDetailsDTO.userId = userId;
				authTokenDetailsDTO.password=password;
				authTokenDetailsDTO.tenantno = tenantno;
				authTokenDetailsDTO.roles = roles;
				authTokenDetailsDTO.from=from;
				authTokenDetailsDTO.userName=userName;
//				authTokenDetailsDTO.menus = menus;
				authTokenDetailsDTO.expirationDate = expirationDate;
			}
		} catch (JwtException ex) {
			ex.printStackTrace();
		}
		return authTokenDetailsDTO;
	}

	private String serializeKey(Key key) {
		String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());
		return encodedKey;
	}

}

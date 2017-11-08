# Proto Demo Core
Microservice or module with common functionality for other services.


keytool -genkeypair -alias jwt -keyalg RSA -dname "CN=jwt, L=foxsermon, S=foxsermon, C=CH" -keypass mySecretKey -keystore jwt.jks -storepass mySecretKey

curl service-account-1:service-account-1-secret@localhost:8080/ProtoDemoSecurity/oauth/token -d grant_type=client_credentials

POST
http://localhost:8080/ProtoDemoSecurity/oauth/token?grant_type=client_credentials

User: service-account-1
Pwd:  service-account-1-secret
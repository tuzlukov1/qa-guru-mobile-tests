package config;
import org.aeonbits.owner.Config;

@Config.Sources({"classpath:properties/browserstack/credentials.properties"})
public interface CredentialsConfig extends Config{

    String user();

    String key();

    String app();

    String url();
}

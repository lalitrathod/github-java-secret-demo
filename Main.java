public class Main {
    public static void main(String[] args) {
        String ldapPassword = ConfigLoader.get("environment.ldap_user.password");
        if (ldapPassword != null) {
            System.out.println("✅ Secret loaded successfully (masked): *********");
        } else {
            System.out.println("❌ Failed to load secret.");
        }
    }
}
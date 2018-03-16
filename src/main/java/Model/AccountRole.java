package Model;

public enum AccountRole {
    admin("admin"), customer("customer");

    private final String name;

    AccountRole(String s) {
        name = s;
    }

    @Override
    public String toString() {
        return this.name;
    }
}

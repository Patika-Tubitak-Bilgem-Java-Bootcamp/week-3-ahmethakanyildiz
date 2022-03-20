package account.enums;

public enum AuthenticationStatus {
    SUCCESS("Giriş Yapılmış"),
    FAIL("Giriş yapıl(a)mamış");

    private final String ad;

    AuthenticationStatus(String s) {
        this.ad=s;
    }

    public String getAd() {
        return ad;
    }
}

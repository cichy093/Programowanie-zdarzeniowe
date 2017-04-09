package twix.login;

import twix.database.TwixKlienci;

public class Login {
    
    private static TwixKlienci zalogowanyUzytkownik;
    
    public static TwixKlienci getZalogowanyUzytkownik() {
        return zalogowanyUzytkownik;
    }
    
    public static void setZalogowanyUzytkownik(TwixKlienci uzytkownik) {
        Login.zalogowanyUzytkownik = uzytkownik;
    }

}

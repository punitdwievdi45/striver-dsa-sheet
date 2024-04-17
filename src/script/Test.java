package script;

public class Test {
    public static void main(String[] args) {


        String originalString = "https://login.microsoftonline.com/common/oauth2/authorize?client_id=22157a52-7011-4edc-924f-8916c6282f33&login_hint=PunitDwivedi@InsideViewDevelopmentAcc350.onmicrosoft.com&prompt=none&redirect_uri=http://login.dev.insideview.com:443/AuthTest/oauth/WAAD_OAUTH/authorize&resource=https://org96e69017.crm8.dynamics.com&response_type=code&state=f51bd761-9a86-4745-a8f7-39ad22a8c9e7";
        String replacedString = originalString.replace("http://", "https://");
        System.out.println(replacedString);

    }
}

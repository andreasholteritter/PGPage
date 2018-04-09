package no.woact.ritand16.selenium.po;

import no.woact.ritand16.selenium.PageObject;

//Created 09/04/2018 by Ritter
//https://github.com/arcuri82/testing_security_development_enterprise_systems/blob/master/intro/exercises/quiz-game/part-10/src/test/java/org/tsdes/intro/exercises/quizgame/selenium/po/SignUpPO.java

public class SignUpPO extends LayoutPO{

    public SignUpPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Sign Up");
    }

    public IndexPO createUser(String userName, String password){

        setText("username", userName);
        setText("password", password);
        clickAndWait("submit");

        IndexPO po = new IndexPO(this);
        if(po.isOnPage()){
            return po;
        }

        return null;
    }
}
package no.woact.ritand16.selenium.po.ui;

import org.openqa.selenium.By;
import no.woact.ritand16.selenium.PageObject;
import no.woact.ritand16.selenium.po.LayoutPO;

public class ResultPO extends LayoutPO {

    public ResultPO(PageObject other) {
        super(other);
    }

    @Override
    public boolean isOnPage() {
        return getDriver().getTitle().contains("Match Result");
    }

    public boolean haveWon(){
        return getDriver().findElements(By.id("wonId")).size() > 0;
    }

    public boolean haveLost(){
        return getDriver().findElements(By.id("lostId")).size() > 0;
    }
}
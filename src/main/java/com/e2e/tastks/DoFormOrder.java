package com.e2e.tastks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.ui.Select;
import net.serenitybdd.screenplay.waits.Wait;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import com.e2e.ui.FormularioForm;

public class DoFormOrder implements Task {
    
	public String name;
	public String country;
	public String city;
	public String card;
	public String month;
	public String year;

    public DoFormOrder() {
		this.name = "Guest";
		this.country = "Ecuador";
		this.city = "Quito";
		this.card = "555-55522111";
		this.month = "8";
		this.year = "28";
    }

    public static Performable withoptions(){
        return instrumented(DoFormOrder.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor)  {
        actor.attemptsTo(
                 Enter.theValue(name).into(FormularioForm.NAME_FIELD),
				 Enter.theValue(country).into(FormularioForm.COUNTRY_FIELD),
				 Enter.theValue(city).into(FormularioForm.CITY_FIELD),
                 Enter.theValue(card).into(FormularioForm.CREDIT_CART_FIELD),
                 Enter.theValue(month).into(FormularioForm.MONTH_FIELD),
                 Enter.theValue(year).into(FormularioForm.YEAR_FIELD),
            	 Click.on(FormularioForm.PURCHASE_ORDER_BUTTON)
        );
    }
}
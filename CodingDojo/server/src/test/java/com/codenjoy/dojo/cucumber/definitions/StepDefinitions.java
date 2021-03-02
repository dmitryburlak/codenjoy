package com.codenjoy.dojo.cucumber.definitions;

/*-
 * #%L
 * Codenjoy - it's a dojo-like platform from developers to developers.
 * %%
 * Copyright (C) 2018 - 2021 Codenjoy
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 * #L%
 */

import com.codenjoy.dojo.cucumber.WebDriverWrapper;
import com.codenjoy.dojo.cucumber.page.ErrorPage;
import com.codenjoy.dojo.cucumber.page.LoginPage;
import com.codenjoy.dojo.cucumber.page.Page;
import com.codenjoy.dojo.cucumber.page.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    @Autowired
    private WebDriverWrapper web;

    @Autowired
    private LoginPage login;

    @Autowired
    private RegistrationPage registration;

    @Autowired
    private ErrorPage error;

    @Autowired
    private Page page;

    @When("Login page opened in browser")
    public void loginPage() {
        login.open();
    }

    @When("Try to login as {string} with {string} password in game {string}")
    public void login(String email, String password, String game) {
        login.email(email);
        login.password(password);
        login.game(game);
        login.submit();
    }

    @Then("See {string} login error")
    public void login(String error) {
        login.assertErrorMessage(error);
    }

    @When("Press register button")
    public void pressRegisterButton() {
        login.clickRegister();
    }

    @When("Try to register with: name {string}, email {string}, " +
            "password {string}, city {string}, " +
            "tech skills {string}, company {string}, " +
            "experience {string}, game {string}")
    public void tryToRegister(String name, String email,
                              String password, String country,
                              String techSkills, String company,
                              String experience, String game)
    {
        registration.name(name);
        registration.email(email);
        registration.password(password);
        registration.confirmPassword(password);
        registration.country(country);
        registration.tech(techSkills);
        registration.company(company);
        registration.experience(experience);
        registration.game(game);
        registration.submit();
    }

    @SneakyThrows
    @Then("On page with url {string}")
    public void assertUrl(String url) {
        assertEquals(page.injectSettings(url), web.url());
    }

    @Given("Clean all registration data")
    public void cleanAllRegistrationData() {
        registration.clear();
    }

    @Then("User registered in database as {string}")
    public void registerUser(String user) {
        registration.assertUserInDatabase(user);
    }

    @When("Logout")
    public void logout() {
        page.logLink().click();
    }

    @Then("Login link present")
    public void loginLinkPresent() {
        assertEquals("Login", page.logLink().getText());
    }

    @Then("Logout link present")
    public void logoutLinkPresent() {
        assertEquals("Logout", page.logLink().getText());
    }

    @Given("User registered with name {string}, email {string}, " +
            "password {string}, city {string}, " +
            "tech skills {string}, company {string}, " +
            "experience {string}")
    public void registerUser(String name, String email,
                              String password, String country,
                              String techSkills, String company,
                              String experience)
    {
        registration.registerInDatabase(name, email, password,
                country, techSkills, company, experience);
    }

    @When("Try open Admin page")
    public void tryOpenAdminPage() {
        web.open("/admin");
    }

    @When("Login as {string} {string}")
    public void loginAs(String email, String password) {
        loginPage();
        login(email, password, "first");
        page.assertPage("board");
        assertUrl("/board/player/<PLAYER_ID>?code=<CODE>&game=first");
    }

    @Then("See {string} message on error page")
    public void seeErrorPageWith(String message) {
        error.assertErrorPage();
        error.assertTicketNumber();
        error.assertErrorMessage(message);
        error.clear();
    }

    @And("Close browser")
    public void closeBrowser() {
        web.exit();
    }
}
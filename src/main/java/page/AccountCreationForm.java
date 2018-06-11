package page;

import org.fluentlenium.core.annotation.Page;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

public class AccountCreationForm extends GenericPage {

    private final String randomValue = randomAlphabetic(5);

    @Override
    public void isAt() {
        await().until(personalInfoGenderCheckbox).clickable();
    }

    @Page
    private
    LoggedInPage loggedInPage;

    @FindBy(id = "id_gender1")
    private FluentWebElement personalInfoGenderCheckbox;

    @FindBy(id = "customer_firstname")
    private FluentWebElement personalInfoFirstNameInput;

    @FindBy(id = "customer_lastname")
    private FluentWebElement personalInfoLastNameInput;

    @FindBy(id = "email")
    private FluentWebElement personalInfoEmailInput;

    @FindBy(id = "passwd")
    private FluentWebElement personalInfoPasswordInput;

    @FindBy(id = "firstname")
    private FluentWebElement addressFirstNameInput;

    @FindBy(id = "lastname")
    private FluentWebElement addressLastNameInput;

    @FindBy(id = "company")
    private FluentWebElement addressCompanyInput;

    @FindBy(id = "address1")
    private FluentWebElement addressAddressInput;

    @FindBy(id = "city")
    private FluentWebElement addressCityInput;

    @FindBy(id = "id_state")
    private WebElement addressStateSelect;

    @FindBy(id = "postcode")
    private FluentWebElement addressPostcodeInput;

    @FindBy(id = "id_country")
    private WebElement addressCountrySelect;

    @FindBy(id = "other")
    private FluentWebElement addressAdditionalInformationInput;

    @FindBy(id = "phone")
    private FluentWebElement addressHomeNumberInput;

    @FindBy(id = "phone_mobile")
    private FluentWebElement addressMobilePhoneInput;

    @FindBy(id = "alias")
    private FluentWebElement addressAliasInput;

    @FindBy(id = "submitAccount")
    private FluentWebElement registerButton;

    public AccountCreationForm fillAccountCreationForm(String email, String password) {
        await().until(personalInfoGenderCheckbox).clickable();
        personalInfoGenderCheckbox.click();
        personalInfoFirstNameInput.fill().withText(randomValue);
        personalInfoLastNameInput.fill().withText(randomValue);
        personalInfoEmailInput.fill().withText(email);
        personalInfoPasswordInput.fill().withText(password);
        addressFirstNameInput.fill().withText(randomValue);
        addressLastNameInput.fill().withText(randomValue);
        addressCompanyInput.fill().withText(randomValue);
        addressAddressInput.fill().withText(randomValue);
        addressCityInput.fill().withText(randomValue);
        selectFirstElementFromDropdown(addressStateSelect);
        addressPostcodeInput.fill().withText(randomNumeric(5));
        selectFirstElementFromDropdown(addressCountrySelect);
        addressAdditionalInformationInput.fill().withText(randomValue);
        addressHomeNumberInput.fill().withText(randomNumeric(5));
        addressMobilePhoneInput.fill().withText(randomNumeric(5));
        addressAliasInput.fill().withText(randomValue);
        return this;
    }

    public LoggedInPage submitAccountCreationForm() {
        await().until(registerButton).clickable();
        registerButton.click();
        return loggedInPage;
    }

    private void selectFirstElementFromDropdown(WebElement element) {
        Select statusDropdown = new Select(element);
        statusDropdown.selectByIndex(1);
    }

}

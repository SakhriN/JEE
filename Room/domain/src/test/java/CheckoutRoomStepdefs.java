import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutRoomStepdefs {
    @Given("the room {string} cost {double}")
    public void theRoomCostPrice(String name, double price) {
    }

    @When("I buy {int} of the book {string}")
    public void iBuyQtyOfTheRoom(int qty, String name) {
    }

    @Then("the total of {string} checkout is {double}")
    public void theTotalOfCheckoutIsTotal(String name, double total) {
    }
}

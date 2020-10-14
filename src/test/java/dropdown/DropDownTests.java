package dropdown;

import base.BaseTests;
import com.ratn.pages.DropdownPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DropDownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.clickDropDown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);

        List<String> selectedOptions = dropdownPage.getSelectedOptions();
        Assert.assertEquals(selectedOptions.size(), 1, "More than 1 value selected.");
        Assert.assertTrue(selectedOptions.get(0).equals(option), "Selected value different from the selected option.");
    }

}

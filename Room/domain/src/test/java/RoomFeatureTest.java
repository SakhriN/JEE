import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.domain.entity.Room;
import org.example.domain.port.RoomRepository;
import org.example.domain.service.RoomService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class RoomFeatureTest {

    private RoomService roomService;
    private Room room;

    private List<Room> resultSearch;

    //private AutoCloseable autoCloseable;

    /*@BeforeEach
    void setUp() {
        autoCloseable = MockitoAnnotations.openMocks(this);
    }*/

    /*@AfterEach
    void close() throws Exception {
        autoCloseable.close();
    }*/
    //@Mock
    private final RoomRepository roomRepository;
    public RoomFeatureTest() {

        roomRepository = Mockito.mock(RoomRepository.class);
        roomService = new RoomService(roomRepository);
        room = new Room.Builder().name("toto").bgndate(Date.valueOf("2020-03-01")).enddate(Date.valueOf("2020-03-05")).build();
    }
    @Given("there are some rooms in the library")
    public void there_are_some_rooms_in_the_library() {
        Mockito.doAnswer(invocationOnMock -> {
            Room b = invocationOnMock.getArgument(0);
            b.setId(1);
            return null;
        }).when(roomRepository).create(room);

        roomService.createRoom("toto", Date.valueOf("2020-03-01"),Date.valueOf("2020-03-05"));
    }
    @When("I search for rooms with name started with {string}")
    public void i_ask_for_all_rooms(String search) {
        Mockito.when(roomRepository.searchRoom(search)).thenReturn(List.of(room));
        resultSearch = roomService.searchRoom(search);
    }
    @Then("List with {int} room should be returned")
    public void all_rooms_should_be_returned(int size) {

        Assertions.assertEquals(size, resultSearch.size());
    }
}

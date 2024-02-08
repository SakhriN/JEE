import io.cucumber.java.en.And;
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
public class DeleteRoomStepdefs {

    private RoomService roomService;
    private Room firstRoom;
    private Room secondRoom;

    private List<Room> resultSearch;

    private final RoomRepository roomRepository;
    public DeleteRoomStepdefs() {
        roomRepository = Mockito.mock(RoomRepository.class);
        roomService = new RoomService(roomRepository);

    }
    @Given("there are two rooms, one with id {int}")
    public void thereAreTwoRoomsOneWithId(int id) {
        firstRoom = new Room.Builder().name("toto").bgndate(Date.valueOf("2020-03-01")).enddate(Date.valueOf("2020-03-05")).id(id).build();
        Mockito.doAnswer(invocationOnMock -> {
            Room r = invocationOnMock.getArgument(0);
            r.setId(id);
            return null;
        }).when(roomRepository).create(firstRoom);
        roomService.createRoom("toto", Date.valueOf("2020-03-01"),Date.valueOf("2020-03-05"));
    }

    @And("second with id {int} in the library")
    public void secondWithIdInTheLibrary(int id) {
        secondRoom = new Room.Builder().name("tata").bgndate(Date.valueOf("2020-03-01")).enddate(Date.valueOf("2020-03-05")).id(id).build();
        Mockito.doAnswer(invocationOnMock -> {
            Room b = invocationOnMock.getArgument(0);
            b.setId(id);
            return null;
        }).when(roomRepository).create(secondRoom);
        roomService.createRoom("tata", Date.valueOf("2020-03-01"),Date.valueOf("2020-03-05"));
    }

    @When("I delete the room with id {int}")
    public void iDeleteTheRoomWithId(int id) {
        Mockito.when(roomRepository.findById(id)).thenReturn(firstRoom);
        roomService.deleteRoom(id);
    }

    @Then("list with one room with id {int} should be returned")
    public void listWithOneRoomWithIdShouldBeReturned(int id) {
        Mockito.when(roomRepository.searchRoom("toto")).thenReturn(List.of(secondRoom));
        resultSearch = roomService.searchRoom("toto");
        Assertions.assertEquals(id, resultSearch.get(0).getId());
    }
}

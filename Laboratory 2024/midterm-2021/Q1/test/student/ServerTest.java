package test.student;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import logic.User;
import logic.Server;
import logic.Channel;
import logic.TemplateType;

public class ServerTest {
	
	User u1;	/* Will always be the Server's owner */
	
	@BeforeEach
	void setUp() {
		u1 = new User("Citron");
	}
	
	@Test
	void testConstructorBasicTemplate() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		
		assertEquals("Server A", s.getName());
		assertEquals(u1, s.getOwner());
		assertEquals(1, s.getMemberList().size());
		assertEquals(u1, s.getMemberList().get(0));
		assertEquals(1, s.getChannelList().size());
		assertEquals("general", s.getChannelList().get(0).getName());
		
		/* Check if the joinedServersList is updated for u1 */
		assertEquals(1, u1.getJoinedServersList().size());
		assertEquals("Server A", u1.getJoinedServersList().get(0).getName());
	}
	
	@Test
	void testConstructorGamingTemplate() {
		Server s = new Server("Server A", u1, TemplateType.GAMING);
		assertEquals("Server A", s.getName());
		assertEquals(u1, s.getOwner());
		assertEquals(1, s.getMemberList().size());
		assertEquals(u1, s.getMemberList().get(0));
		assertEquals(1, s.getChannelList().size());
		assertEquals("gaming", s.getChannelList().get(0).getName());
		assertEquals(1, u1.getJoinedServersList().size());
		assertEquals("Server A", u1.getJoinedServersList().get(0).getName());
	}
	
	@Test
	void testConstructorStudyTemplate() {
		Server s = new Server("Server A", u1, TemplateType.STUDY);
		assertEquals("Server A", s.getName());
		assertEquals(u1, s.getOwner());
		assertEquals(1, s.getMemberList().size());
		assertEquals(u1, s.getMemberList().get(0));
		assertEquals(1, s.getChannelList().size());
		assertEquals("homework-help", s.getChannelList().get(0).getName());
		assertEquals(1, u1.getJoinedServersList().size());
		assertEquals("Server A", u1.getJoinedServersList().get(0).getName());
	}
	
	@Test
	void testConstructorEmptyServerName() {
		Server s = new Server("", u1, TemplateType.BASIC);
		assertEquals("Citron home", s.getName());
		assertEquals(u1, s.getOwner());
		assertEquals(1, s.getMemberList().size());
		assertEquals(u1, s.getMemberList().get(0));
		assertEquals(1, s.getChannelList().size());
		assertEquals("general", s.getChannelList().get(0).getName());
		assertEquals(1, u1.getJoinedServersList().size());
		assertEquals("Citron home", u1.getJoinedServersList().get(0).getName());
	}
	
	@Test
	void testSetName() {
		Server s = new Server("Server A", u1, TemplateType.STUDY);
		s.setName("NoIdeaName");
		assertEquals("NoIdeaName", s.getName());
	}
	
	@Test
	void testSetNameEmpty() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		s.setName("");
		assertEquals("Citron home", s.getName());
		s.setName("            ");
		assertEquals("Citron home", s.getName());
	}
	
	@Test
	void testAddUser() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		
		s.addUser(u2);
		assertEquals(2, s.getMemberList().size());
		User userToCheck = s.getMemberList().get(1);
		assertEquals("Stanislav", userToCheck.getName());
		
		/* Check if the joinedServersList is also updated for u2 */
		assertEquals(1, u2.getJoinedServersList().size());
		assertEquals("Server A", u2.getJoinedServersList().get(0).getName());
	}
	
	@Test
	void testAddDuplicateUser() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		
		s.addUser(u2);
		assertNull(s.addUser(u2));	
		assertEquals(2, s.getMemberList().size());
		
		/* added part */
		User u3 = new User("Stanislav");
		assertNull(s.addUser(u3));
		/* end of checking */
		
	}
	
	@Test
	void testKickUser() throws Exception {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		User u3 = new User("Dennis");
		s.addUser(u2);
		s.addUser(u3);
		
		boolean successKick = s.kickUser(u1, u2);
		assertTrue(successKick);
		assertEquals(2, s.getMemberList().size());
		assertEquals(u1, s.getMemberList().get(0));
		assertEquals(u3, s.getMemberList().get(1));
		assertEquals(0, u2.getJoinedServersList().size());
	}
	
	@Test
	void testKickUserNotOwner() throws Exception {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		User u3 = new User("Dennis");
		s.addUser(u2);
		s.addUser(u3);
		
		assertThrows(Exception.class, () -> s.kickUser(u2, u3));
		assertEquals(3, s.getMemberList().size());
		assertThrows(Exception.class, () -> s.kickUser(u3, u2));
		assertEquals(3, s.getMemberList().size());
	}
	
	@Test
	void testKickUserNonExistingUserOrKickingOwner() throws Exception {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		User u3 = new User("Dennis");
		s.addUser(u2);
		s.addUser(u3);
		
		User u4 = new User("Brian");
		
		assertFalse(s.kickUser(u1, u1));
		assertEquals(3, s.getMemberList().size());
		assertFalse(s.kickUser(u1, u4));
		assertEquals(3, s.getMemberList().size());
	}
	
	
	@Test
	void testAddChannelOwner() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		
		s.addChannel(u1, "Off-topic");
		assertEquals(2, s.getChannelList().size());
		
		Channel c = s.getChannelList().get(1);
		assertEquals("Off-topic", c.getName());
		assertEquals(0, c.getMessageList().size());
	}
	
	@Test
	void testAddChannelNotOwner() {
		Server s = new Server("Server A", u1, TemplateType.BASIC);
		User u2 = new User("Stanislav");
		s.addUser(u2);
		
		assertNull(s.addChannel(u2, "Trolling"));
		assertEquals(1, s.getChannelList().size());
	}
	
}

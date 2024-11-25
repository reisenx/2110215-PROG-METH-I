package main;

import java.util.ArrayList;
import java.util.Scanner;

import logic.Channel;
import logic.Message;
import logic.Server;
import logic.TemplateType;
import logic.User;

public class DiscordMain {
	private static Scanner sc = new Scanner(System.in);

	private static ArrayList<User> usersList;
	private static ArrayList<Server> serversList;
	
	private static User currentUser;
	private static Server currentServer;
	private static Channel currentChannel;
	
	/* Main Menu Begin */
	public static void main(String[] args) {
		initializeProgram();
		
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("simple discord main menu: ");
			System.out.println("please pick an option");
			System.out.println("1) log in");
			System.out.println("2) sign up");
			System.out.println("3) exit");
				int choice = getChoiceInput();
				switch(choice) {
				case 1:
					logInMenu();
					break;
				case 2:
					signUpMenu();
					break;
				case 3:
					isFinished = true;
					break;
				default:
					break;
				}
				printBlock();
		}
		System.out.println("exiting simple discord program");
	}

	private static void signUpMenu() {
		printBlock();
		System.out.println("sign up menu:");
		System.out.println("enter a new username: ");
		boolean isFinished = false;
		User newUser = null;
		while (!isFinished) {
			String username = getTextInput();
			if (isInUsersList(newUser = new User(username))) {
				System.out.println("username already exist, please pick a new one");
			}
			else {
				isFinished = true;
			}
		}
		usersList.add(newUser);
		System.out.println("new user successfully created");
		System.out.println("please log in");
	}

	private static void logInMenu() {
		printBlock();
		System.out.println("log in menu:");
		System.out.println("choose a user: ");
		for (int i = 0; i < usersList.size(); ++i) {
			System.out.println(i+1 + ") " +  usersList.get(i).getName());
		}
		int choice = getChoiceInput();
		if (choice < usersList.size() + 1) {
			currentUser = usersList.get(choice - 1);
			UserMenu();
		}
		else {
			System.out.println("log in error: invalid user choice");
		}
	}
	/* Main Menu End*/
	
	/* User Menu Begin */
	private static void UserMenu() {
		printBlock();

		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("user menu:");
			System.out.println("logged in as: " + currentUser.getName());
			System.out.println();
			System.out.println("1) enter a server");
			System.out.println("2) join a new server");
			System.out.println("3) create a new server");
			System.out.println("4) change display status");
			System.out.println("5) change username");
			System.out.println("6) logout");
			
			int choice = getChoiceInput();
			switch (choice) {
			case 1:
				chooseServerMenu();
				break;
			case 2:
				joinNewServerMenu();
				break;
			case 3:
				createNewServerMenu();
				break;
			case 4:
				changeDisplayStatusMenu();
				break;
			case 5:
				changeUsernameMenu();
				break;
			case 6:
				isFinished = true;
				break;
			default:
				System.out.println("error: invalid action option, please retry");
				break;
			}
			printBlock();
		}
		System.out.println("logged out, returning back to main menu");
	}

	private static void changeUsernameMenu() {
		printBlock();
		System.out.println("new username: ");
		String username = getTextInput();
		User tmpUser = null;
		if (isInUsersList(tmpUser = new User(username))) {
			System.out.println("error: invalid username, exiting without change");
		}
		else {
			currentUser.setName(username);
			System.out.println("succesfully changed username");
		}
	}

	private static void changeDisplayStatusMenu() {
		printBlock();
		System.out.println("current display status: " + currentUser.getStatus());
		System.out.println("new display status: ");
		String status = getTextInput();
		currentUser.setStatus(status);
		System.out.println("status successfully changed");
	}

	private static void createNewServerMenu() {
		printBlock();
		System.out.print("new server name: ");
		String serverName = getTextInput();	
		
		boolean creationOkay = true;
		for (Server s: serversList) {
			if (s.getName().equals(serverName) && s.getOwner() == currentUser) {
				creationOkay = false;
				break;
			}
		}
		if (!creationOkay) {
			System.out.println("server creation error: invalid server name");
			return ;
		}
		
		System.out.println("choose a template type: ");
		System.out.println("1) BASIC (default template)");
		System.out.println("2) GAMING");
		System.out.println("3) STUDY");
		System.out.print("choose a template type: ");
		int choice = getChoiceInput();
		if (choice != 1 && choice != 2 && choice != 3) {
			System.out.println("error: invalid choice, setting the template type to BASIC");
			choice = 1;
		}
		TemplateType template;
		switch (choice) {
		case 2:
			template = TemplateType.GAMING;
			break;
		case 3:
			template = TemplateType.STUDY;
			break;
		default:
			template = TemplateType.BASIC;
			break;
		}
		
		Server s = new Server(serverName, currentUser, template);
		serversList.add(s);
		System.out.println("succesfully created a new server " + s.getName());
		
	}

	private static void joinNewServerMenu() {
		if (currentUser.getJoinedServersList().size() == serversList.size()) {
			System.out.println("you have joined all existing servers");
			return;
		}
		
		System.out.println("list of servers to join");
		int i, j;
		ArrayList<Server> unJoinedServerList = new ArrayList<Server>();
		for (i = 0, j = 0; i < serversList.size(); ++i) {
			Server s = serversList.get(i);
			if (!s.getMemberList().contains(currentUser)) {
				System.out.println(j+1 + ") " +  serversList.get(i).getName() + " (owned by: "
						+ s.getOwner().getName() + ")");
				unJoinedServerList.add(s);
				++j;
			}
		}
		
		int choice = getChoiceInput();
		if (choice < unJoinedServerList.size() + 1) {
			Server s = unJoinedServerList.get(choice - 1);
			s.addUser(currentUser);
			System.out.println("succesfully joined the server " + s.getName());
		}
		else {
			System.out.println("server choosing error: invalid server option");
		}
		
	}

	private static void chooseServerMenu() {
		printBlock();
		
		ArrayList<Server> listToPrint = currentUser.getJoinedServersList();
		if (listToPrint.size() == 0) {
			System.out.println("no servers joined.");
			return ;
		}
		System.out.println("please pick a server from the list below");
		System.out.println();
		for (int i = 0; i < listToPrint.size(); ++i) {
			System.out.println(i+1 + ") " +  listToPrint.get(i).getName());
		}
		System.out.println();
		int choice = getChoiceInput();
		if (choice < listToPrint.size() + 1) {
			currentServer = listToPrint.get(choice - 1);
			serverMainMenu();
		}
		else {
			System.out.println("server choosing error: invalid server option");
		}
	
	}
	/*User Menu End */
	
	/* Server Menu Begin */
	private static void serverMainMenu() {
		printBlock();
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println(currentServer.getName() + " Server : menu");
			System.out.println();
			System.out.println("1) display all members");
			System.out.println("2) enter a channel");
			System.out.println("3) create new channel");
			System.out.println("4) kick a member");
			System.out.println("5) return to user menu");
			
			int choice = getChoiceInput();
			switch (choice) {
			case 1:
				displayServerMembers();
				break;
			case 2:
				enterChannelMenu();
				break;
			case 3:
				createNewChannelMenu();
				break;
			case 4:
				kickMemberMenu();
				break;
			case 5:
				isFinished = true;
				break;
			default:
				System.out.println("error: invalid action option, please retry");
				break;
			}
			System.out.println("returning back to server menu");
			printBlock();
		}
		
	}

	private static void kickMemberMenu() {
		printBlock();
		System.out.println("select a member to be removed: ");
		ArrayList<User> memberList = currentServer.getMemberList();
		for (int i = 0; i < memberList.size(); ++i) {
			User u = memberList.get(i);
			System.out.println(i+1 + ") " + u.getName() + (u.equals(currentServer.getOwner()) ? " (owner)" : ""));
		}
		int choice = getChoiceInput();
		User kicked = memberList.get(choice - 1);
		
		try {
			if(currentServer.kickUser(currentUser, kicked) == false) {
				System.out.println("error: owner can't be removed");
			}
			else {
				System.out.println("successfully removed " + kicked.getName() + " from the server");
			}
			
		} catch (Exception e) {
			System.out.println("error: require owner permission to remove a user");
		}
	}

	private static void createNewChannelMenu() {
		printBlock();
		System.out.print("new channel name: ");
		String channelName = getTextInput();
		if (currentServer.addChannel(currentUser, channelName) != null) {
			System.out.println("successfully created a new channel");
		}
		else {
			System.out.println("error: require owner permission to create a new channel");
		}
	}

	private static void displayServerMembers() {
		printBlock();
		System.out.println("showing " + currentServer.getMemberList().size() + " members in this server");
		System.out.println();
		for (User u: currentServer.getMemberList()) {
			System.out.println(u.getName() + " : " + u.getStatus() + (u.equals(currentServer.getOwner()) ? " (owner)" : ""));
		}
		System.out.println();
	}
		
	private static void enterChannelMenu() {
		printBlock();
		System.out.println("please choose a channel from the list below");
		System.out.println();
		
		ArrayList<Channel> listToPrint = currentServer.getChannelList();
		for (int i = 0; i < listToPrint.size(); ++i) {
			System.out.println(i+1 + ") #" +  listToPrint.get(i).getName());
		}
		System.out.println();
		int choice = getChoiceInput();
		if (choice < listToPrint.size() + 1) {
			currentChannel = listToPrint.get(choice-1);
			channelMainMenu();
		}
		else {
			System.out.println("error: invalid channel option");
		}
	}
	/* Server Menu End */
	
	/*Channel Menu Begin */
	private static void channelMainMenu() {
		printBlock();
		boolean isFinished = false;
		while (!isFinished) {
			System.out.println("Channel menu: " + currentChannel.getName());
			System.out.println();
			System.out.println("1) display all messages");
			System.out.println("2) write a new message");
			System.out.println("3) return to server menu");
			
			int choice = getChoiceInput();
			switch (choice) {
			case 1:
				displayChannelMessages();
				break;
			case 2:
				writeNewMessageMenu();
				break;
			case 3:
				isFinished = true;
				break;
			default:
				System.out.println("error: invalid action option, please retry");
				break;
			}
			System.out.println("returning back to server menu");
			printBlock();
		}
	}

	private static void writeNewMessageMenu() {
		printBlock();
		System.out.print("enter the message: ");
		String text = getTextInput();
		Message m = new Message(text, currentUser);
		currentChannel.addMessage(m);
		System.out.println("message succesfully sent");
	}

	private static void displayChannelMessages() {
		printBlock();
		System.out.println(currentChannel.getName() + ": ");
		if (currentChannel.getMessageCount() == 0) {
			System.out.println();
			System.out.println("no messages to display");
			return;
		}
		System.out.println();
		int i;
		for (i = 0; i < currentChannel.getMessageList().size(); ++i) {
			Message m = currentChannel.getMessageList().get(i);
			System.out.println(m.getSender().getName() + ": " + m.getText());
		}
		System.out.println();
		System.out.println("total message(s) count: " + i);
	}
	/* Channel Menu End */
	
	/* Utility Begin */
	private static boolean isInUsersList(User user) {
		for (User u: usersList)
			if(u.equals(user))
				return true;
		return false;
	}
	
	private static int getChoiceInput() {
		System.out.print(">> ");
		int choice = sc.nextInt();
		sc.nextLine();
		return choice;
	}
	
	private static String getTextInput() {
		System.out.print(">> ");
		return sc.nextLine();
	}
	
	private static void printBlock() {
		System.out.println("=======================");
	}

	private static void initializeProgram() {
		usersList = new ArrayList<User>();
		serversList = new ArrayList<Server>();
		
		User u1 = new User("Luffy");
		User u2 = new User("Zoro");
		User u3 = new User("Nami");
		
		User u4 = new User("Akainu");
		User u5 = new User("Kizaru");
		User u6 = new User("Aokiji");
		User u7 = new User("Sengoku");
		
		u1.setStatus("I am going to be the pirate king");
		u2.setStatus("meditating");
		u3.setStatus("$$$");
		
		u4.setStatus("justice!");
		u5.setStatus("interesting");
		u6.setStatus("zzz");
		u7.setStatus("the sea is calm");
		
		usersList.add(u1);
		usersList.add(u2);
		usersList.add(u3);
		usersList.add(u4);
		usersList.add(u5);
		usersList.add(u6);
		usersList.add(u7);
		
		Server s1 = new Server("Straw Hat Crew", u1, TemplateType.BASIC);
		Server s2 = new Server("Marine HeadQuater", u7, TemplateType.STUDY);
		serversList.add(s1);
		serversList.add(s2);
		
		s1.addUser(u2);
		s1.addUser(u3);
		
		s2.addUser(u4);
		s2.addUser(u5);
		s2.addUser(u6);
		
		s1.addChannel(u1, "adventure-plan");
		s1.addChannel(u1, "ship-discuss");
		
		s1.getChannelList().get(1).addMessage(new Message("to Grand Line!!", u1));
		s1.getChannelList().get(1).addMessage(new Message("i must become stronger", u2));
		s1.getChannelList().get(1).addMessage(new Message("that's completely off-topic!", u3));
		
		s1.getChannelList().get(2).addMessage(new Message("hey, we need a better ship!", u3));
		s1.getChannelList().get(2).addMessage(new Message("let's head south, there's a village there", u3));
		s1.getChannelList().get(2).addMessage(new Message("food!", u1));
		
		s2.getChannelList().get(0).addMessage(new Message("did you guys study properly?", u7));
	}
	/* Utility End */
}

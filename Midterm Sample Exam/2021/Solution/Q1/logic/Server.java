package logic;

import java.util.ArrayList;

public class Server {
	private String name;
	private  User owner;
	private ArrayList<Channel> channelList;

	private ArrayList<User> memberList;

	public  Server(String name, User owner, TemplateType template) {
		setOwner(owner); //Set the owner of the Server to the specified owner.

		memberList = new ArrayList<User>(); //Initialize the memberList.
		channelList = new ArrayList<Channel>(); //Initialize the channelList.

		addUser(owner); //Add the owner to the memberList
		setName(name); //Add  this Server owner’s joinedServersList.
		if(template.equals(TemplateType.BASIC)){// Then create and add 1 Channel to the channelList depending on the TemplateType specified.
			addChannel(owner,"general");
		}
		else if(template.equals(TemplateType.GAMING)){
			addChannel(owner,"gaming");
		}
		else if(template.equals(TemplateType.STUDY)){
			addChannel(owner,"homework-help");
		}
	}
	public Channel addChannel(User user, String channelName){
		if (user.equals(getOwner())){ //Is Owner,Create Channel
			Channel channel = new Channel(channelName);
		  channelList.add(channel);
		  return channel;
		}
		return null; //not Owner return null;
	}

	public User addUser(User user){
		if(memberList.contains(user)){//user already in server,do nothing
			return null;
		}
		else{
		memberList.add(user);
		user.getJoinedServersList().add(this);
		return user;}
	}
	public  boolean kickUser(User kicker, User kicked) throws
			Exception{
		if (kicker.equals(getOwner())){//kicker is owner
			if(memberList.contains(kicked)&&!kicked.equals(kicker)){// kicked exist and not owner;
				kicked.getJoinedServersList().remove(this);
				return memberList.remove(kicked);
			}
			else{
				return false;
			}
		}
		throw new Exception(); //kicker is not owner
	}

	public void setName(String name) {
		if (name.isBlank()) {
			this.name = getOwner().getName()+" home";
		}
		else {
			this.name = name;
		}
	}


	public String getName() {
		return name;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public ArrayList<Channel> getChannelList() {
		return channelList;
	}

	public void setChannelList(ArrayList<Channel> channelList) {
		this.channelList = channelList;
	}

	public ArrayList<User> getMemberList() {
		return memberList;
	}

	public void setMemberList(ArrayList<User> memberList) {
		this.memberList = memberList;
	}




}

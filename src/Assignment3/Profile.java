package Assignment3;
public class Profile {
    private String name, status, pathToImage;
    FriendNode friendHead;
    public Profile(String name, String status, String pathToImage){
        this.name = name;
        this.status = status;
        this.pathToImage = pathToImage;
        friendHead = null;
    }
    public void addFriend(Profile friend){
        FriendNode newFriend = new FriendNode(friend);
        if (friendHead == null){
            friendHead = newFriend;
        }else {
            FriendNode tempFriend = new FriendNode(friend);
            while (tempFriend.next != null) {
                tempFriend = tempFriend.next;
            }
            tempFriend.next = newFriend;
        }

    }
    public void removeFriend(Profile toRemovefriend){
        if (friendHead.friend.name.equals(toRemovefriend.name)){
            friendHead = friendHead.next;
            return;
        }
        FriendNode tempFriend = new FriendNode(toRemovefriend);
        while(tempFriend.next != null){
            if (tempFriend.friend.name.equals(toRemovefriend.name)){
                tempFriend.next = tempFriend.next.next;
            }
        }
    }
    public String displayFriends(){
        if (friendHead == null) return "No friends yet.";
        StringBuilder friendList = new StringBuilder("Friends:\n");
        FriendNode current = friendHead;
        while (current != null) {
            friendList.append(current.friend.name).append("\n");
            current = current.next;
        }
        return friendList.toString();
    }
}

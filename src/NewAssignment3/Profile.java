package NewAssignment3;

class Profile {
    String name;
    String image;
    String status;
    FriendNode friendsHead;

    public Profile(String name, String image, String status) {
        this.name = name;
        this.image = image;
        this.status = status;
        this.friendsHead = null;
    }

    public void addFriend(Profile friend) {
        if (!isFriend(friend)) {
            FriendNode newFriend = new FriendNode(friend);
            newFriend.next = friendsHead;
            friendsHead = newFriend;
        }
    }

    public void removeFriend(Profile friend) {
        FriendNode current = friendsHead, prev = null;
        while (current != null && current.friend != friend) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) {
                friendsHead = current.next;
            } else {
                prev.next = current.next;
            }
        }
    }

    public boolean isFriend(Profile friend) {
        FriendNode current = friendsHead;
        while (current != null) {
            if (current.friend == friend) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nImage: " + (image.isEmpty() ? "No image" : image) + "\nStatus: " + status;
    }

    public String listFriends() {
        if (friendsHead == null) return "No friends yet.";
        StringBuilder friendList = new StringBuilder("Friends:\n");
        FriendNode current = friendsHead;
        while (current != null) {
            friendList.append(current.friend.name).append("\n");
            current = current.next;
        }
        return friendList.toString();
    }
}

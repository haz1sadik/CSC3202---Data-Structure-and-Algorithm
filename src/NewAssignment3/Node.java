package NewAssignment3;

class Node {
    Profile profile;
    Node next;

    public Node(Profile profile) {
        this.profile = profile;
        this.next = null;
    }
}
class FriendNode {
    Profile friend;
    FriendNode next;

    public FriendNode(Profile friend) {
        this.friend = friend;
        this.next = null;
    }
}
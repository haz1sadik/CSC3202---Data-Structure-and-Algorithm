package NewAssignment3;

class MukaBuku {
    Node head;

    public MukaBuku() {
        this.head = null;
    }

    public void addProfile(String name, String image, String status) {
        Profile newProfile = new Profile(name, image, status);
        Node newNode = new Node(newProfile);
        newNode.next = head;
        head = newNode;
    }

    public void removeProfile(String name) {
        Node current = head, prev = null;
        while (current != null && !current.profile.name.equalsIgnoreCase(name)) {
            prev = current;
            current = current.next;
        }
        if (current != null) {
            if (prev == null) {
                head = current.next;
            } else {
                prev.next = current.next;
            }
            Node temp = head;
            while (temp != null) {
                temp.profile.removeFriend(current.profile);
                temp = temp.next;
            }
        }
    }

    public Profile findProfile(String name) {
        Node current = head;
        while (current != null) {
            if (current.profile.name.equalsIgnoreCase(name)) {
                return current.profile;
            }
            current = current.next;
        }
        return null;
    }

    public void displayProfiles() {
        if (head == null) {
            System.out.println("No profiles in the network.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.profile);
            System.out.println(current.profile.listFriends());
            System.out.println("---------------------------");
            current = current.next;
        }
    }
}
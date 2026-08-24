import java.util.*;

class ContactManager {

    
    public static void removeContact(HashMap<String, Contact> contacts, String contact) {

        contacts.remove(contact);

    }
    
    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<String, Contact>();

        // Step 4:  add contacts here

        for(int i=9; i>0; i--) {

            contacts.put("First" + i + " Last" + i, new Contact("First" + i + " Last" + i, "+1 (415) 500-500" + i));

        }

        

        // Step 5:  look up a contact

        Contact c;
        String lookup = "First8 Last8";

        System.out.println("Looking up name: " + lookup);

        if( (c = contacts.get(lookup)) != null) {
            System.out.println(c);
        } else {
            System.out.println("Contact not found.");
        }


        // Step 6:  print sorted list

        //removeContact(contacts, "First7 Last7");

        ArrayList<Contact>  sorted = new ArrayList<Contact>(contacts.values());

        sorted.sort( (a,b) -> a.getName().compareTo(b.getName())  );


        System.out.println("---- All Contacts ----");

        for(Contact ct : sorted) {
            System.out.println(ct);
        }


    }





}
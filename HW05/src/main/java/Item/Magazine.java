package Item;

public class Magazine extends Item {
    private final String issueNumber;
    private final String publicationDate;

    public Magazine(String title, String issueNumber, String publicationDate) {
        super(title);
        this.issueNumber = issueNumber;
        this.publicationDate = publicationDate;
        System.out.println("Magazine constructor called.");
    }

    @Override
    public void borrow() {
        System.out.println("Borrowing the magazine: " + getIdentifier());
    }

    @Override
    public void returnItem() {
        System.out.println("Returning the magazine: " + getIdentifier());
    }

    @Override
    public Magazine getItemDetails() {
        System.out.println("Magazine: " + title + ", Issue Number: " +
                issueNumber + ", Publication Date: " + publicationDate);
        return this;
    }

}

package ImageHoster.model;

import javax.persistence.*;

import java.util.Date;


@Entity

@Table(name = "comments")
public class Comment {
    //@Id annotation specifies that the corresponding attribute is a primary key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    //Here the column name is explicitly mentioned as 'id'
    @Column(name = "id")
    private int id;

    // text based data that will be longer than 256 characters
    @Column(columnDefinition = "text")
    private String text;
    @Column(name = "date")
   private Date createdDate;

    //The 'comments' table is mapped to 'users' table with ManytoOne mapping
    //One comment can have only one user (owner) but one user can have multiple comments.
    //FetchType is EAGER
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;
    // The 'comment' table is mapped to 'images' table with ManytoOne mapping.
    //One comment can have only one Image  but one Image can have multiple comments.
    //FetchType is EAGER.
    @ManyToOne(fetch = FetchType.EAGER)
    private Image image;

    public Comment (){}




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return createdDate;
    }

    public void setDate(Date date) {
        this.createdDate = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}

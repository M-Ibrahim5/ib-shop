//import com.ibrahim.ib_shop.Model.Admin;
//import com.ibrahim.ib_shop.Model.Customer;
//import com.ibrahim.ib_shop.Model.Role;
//import com.ibrahim.ib_shop.Model.Seller;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "users")  // Avoid "user" as it's a reserved keyword in some DBs
//public class User {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(unique = true, nullable = false)
//    private String username;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(unique = true, nullable = false)
//    private String email;
//
//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Customer customer;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Seller seller;
//
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Admin admin;
//}

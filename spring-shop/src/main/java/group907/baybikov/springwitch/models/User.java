package group907.baybikov.springwitch.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String firstname;
    private String lastname;
    private String email;

    @Builder.Default
    private String image = "profile.png";

    @Column(name = "confirmed_code")
    private String confirmedCode;

    @Column(name = "hash")
    private String password;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private State state = State.ACTIVE;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private Role role = Role.USER;

    @Builder.Default
    @Enumerated(value = EnumType.STRING)
    private Status status = Status.NOT_CONFIRMED;

    public enum State {
        ACTIVE, BANNED
    }

    public enum Status {
        CONFIRMED, NOT_CONFIRMED
    }

    public enum Role {
        USER, ADMIN
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isConfirmed() {
        return this.status == Status.CONFIRMED;
    }
}

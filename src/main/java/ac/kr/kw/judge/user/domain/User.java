package ac.kr.kw.judge.user.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int accumulateScore;

    @Enumerated(EnumType.STRING)
    private Rank rank;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private User(String username, String password) {
        this.username = username;
        this.password = password;
        this.rank = Rank.BRONZE.getDefaultRank();
        this.accumulateScore = 0;
    }

    public static User of(String username, String password) {
        return new User(username, password);
    }

    protected User() {
        //empty
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getAccumulateScore() {
        return accumulateScore;
    }

    public Rank getRank() {
        return rank;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}

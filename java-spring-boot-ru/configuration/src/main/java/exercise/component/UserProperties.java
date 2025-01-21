package exercise.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "users")
@Getter
@Setter
public class UserProperties {
    @Value("admins")
    private List<String> admins;
}

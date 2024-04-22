package pl.piwowarski.socialmediabackend.provider;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import pl.piwowarski.socialmediabackend.dto.user.GetUserDto;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TestDataProvider {

    public static GetUserDto getUserDto = GetUserDto.builder().build();
}

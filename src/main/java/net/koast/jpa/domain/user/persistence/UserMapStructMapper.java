package net.koast.jpa.domain.user.persistence;

import net.koast.jpa.common.mapstruct.MapStructMapper;
import net.koast.jpa.common.mapstruct.MapStructMapperConfig;
import net.koast.jpa.domain.user.dto.UserInfoDto;
import net.koast.jpa.domain.user.entity.UserInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(config = MapStructMapperConfig.class)
public interface UserMapStructMapper extends MapStructMapper<UserInfoDto, UserInfo> {

    UserMapStructMapper INSTANCE = Mappers.getMapper(UserMapStructMapper.class);

    @Override
    @Mapping(target = "userId", ignore = true)
    UserInfo toEntity(UserInfoDto dto);
}
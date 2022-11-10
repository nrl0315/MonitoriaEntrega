package edu.uco.monitoria.domain.builder;

import edu.uco.monitoria.domain.PlaceDTO;

import java.util.UUID;

public final class PlaceDTOBuilder {
    private UUID id;
    private String block;
    private String classRoom;

    private PlaceDTOBuilder(){
        super();
    }

    public static final PlaceDTOBuilder getPlaceDTOBuilder(){
        return new PlaceDTOBuilder();
    }

    public final PlaceDTOBuilder setId(final UUID id) {
        this.id = id;
        return this;
    }

    public final PlaceDTOBuilder setBlock(final String block) {
        this.block = block;
        return this;
    }

    public final PlaceDTOBuilder setClassRoom(final String classRoom) {
        this.classRoom = classRoom;
        return this;
    }

    public final PlaceDTO build(){
        return PlaceDTO.create(id,block,classRoom);
    }
}

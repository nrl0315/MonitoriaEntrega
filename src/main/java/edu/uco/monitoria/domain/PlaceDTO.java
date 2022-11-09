package edu.uco.monitoria.domain;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;

public final class PlaceDTO {
    private UUID id;
    private String block;
    private String classRoom;

    public PlaceDTO(){
        setId(getDefaultUUID(id));
        setBlock(EMPTY);
        setClassRoom(EMPTY);
    }

    public PlaceDTO(UUID id, String block, String classRoom) {
        setId(getDefaultUUID(id));
        setBlock(block);
        setClassRoom(classRoom);
    }

    public static final PlaceDTO create(final UUID id, final String block, final String classRoom){
        return new PlaceDTO(id,block,classRoom);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = getDefaultUUID(id);
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }
}

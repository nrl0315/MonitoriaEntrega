package edu.uco.monitoria.domain;

import edu.uco.monitoria.crosscuting.helper.UUIDHelper;

import java.util.UUID;
import static edu.uco.monitoria.crosscuting.helper.StringHelper.EMPTY;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getDefaultUUID;
import static edu.uco.monitoria.crosscuting.helper.NumberHelper.ZERO;
import static edu.uco.monitoria.crosscuting.helper.UUIDHelper.getUUIDFromString;

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

    public static final PlaceDTO create(final String id, final String block, final String classRoom){
        return new PlaceDTO(getUUIDFromString(id),block,classRoom);
    }

    public static final PlaceDTO create(final UUID id){
        return new PlaceDTO(id, EMPTY, EMPTY);
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

    public final String getUUIDAsString(){
        return UUIDHelper.getUUIDAsString(getId());
    }
}

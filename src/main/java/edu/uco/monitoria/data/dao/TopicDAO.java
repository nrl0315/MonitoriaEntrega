package edu.uco.monitoria.data.dao;

import edu.uco.monitoria.domain.TopicDTO;

import java.util.List;

public interface TopicDAO {
    void create(final TopicDTO topic);
    void update(final TopicDTO topic);
    List<TopicDTO> find(final TopicDTO topic);
    void delete(TopicDTO topic);
}


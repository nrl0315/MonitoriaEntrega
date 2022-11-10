package edu.uco.monitoria.data.dao;

import edu.uco.monitoria.domain.ReviewDTO;

import java.util.List;

public interface ReviewDAO {
    void create(final ReviewDTO review);
    List<ReviewDTO> find(final ReviewDTO review);
    void update(final ReviewDTO review);
}

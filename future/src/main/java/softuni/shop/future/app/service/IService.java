package softuni.shop.future.app.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
}

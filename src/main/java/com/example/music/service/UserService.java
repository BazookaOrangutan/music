package com.example.music.service;

import com.example.music.model.User;

import java.util.List;
import java.util.UUID;

/**
 * Сервис управления пользователями
 */
public interface UserService {

    /**
     * Создание пользователя
     *
     * @param user пользователь
     * @return созданный пользователь
     */
    User createUser(User user);

    /**
     * Получение пользователя по его уникальному идентификатору
     *
     * @param id уникальный идентификатор пользователя
     * @return найденный пользователь
     */
    User getUserById(UUID id);

    /**
     * Обновление пользователя
     *
     * @param id уникальный идентификатор пользователя
     * @param user пользователь
     * @return обновленный пользователь
     */
    User updateUser(UUID id, User user);

    /**
     * Удаление пользователя
     *
     * @param id уникальный идентификатор пользователя
     */
    void deleteUserById(UUID id);

    /**
     * Получение списка всех пользователей
     *
     * @return список пользователей
     */
    List<User> getAllUsers();
}

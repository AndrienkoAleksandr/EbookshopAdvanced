package com.bookshop.dao;

import com.bookshop.dao.factory.cheking.SpecialCheckingOfConnection;
import com.bookshop.exception.ConnectionException;
import com.bookshop.exception.DataBaseNotFound;
import com.bookshop.model.User;
import com.bookshop.util.DataBaseConnection;

import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by USER on 13.08.2014.
 */
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByName(String userName) throws ConnectionException, DataBaseNotFound {
        User user = null;
        ResultSet resultSet = null;
        String sql = "SELECT * FROM users where users.name = ?";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, userName);
            preparedStatement.executeQuery();
            resultSet = preparedStatement.getResultSet();
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setPhone(resultSet.getString("phone"));
                user.setPermission(resultSet.getInt("permission"));
                user.setPassword(resultSet.getString("password"));
            }
        } catch ( ClassNotFoundException e) {
            e.printStackTrace();
        } catch(SQLException e) {
            e.printStackTrace();
            SpecialCheckingOfConnection.checkConnection(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    @Override
    public boolean addUser(User user) throws ConnectionException, DataBaseNotFound {
        boolean isSuccess = false;
        String sql = "INSERT into users (name, email, phone, permission, password)" +
                "value (?, ?, ?, ?, ?)";
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPhone());
            preparedStatement.setInt(4, user.getPermission());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.execute();
            isSuccess = true;
        } catch (ClassNotFoundException  e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            SpecialCheckingOfConnection.checkConnection(e);
        }
        return isSuccess;
    }
}

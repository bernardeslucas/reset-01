package management;

import objects.User;
import storage.UserStorage;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class UserManagement {

    private UserStorage storage = new UserStorage();


    public User create (User user){
        List<User> userList = storage.list();

        for (User userExistent : userList){
            if(user.getEmail().equals(userExistent.getEmail())){
                return userExistent;
            }
        }
        if (Period.between(user.getBirthDate(), LocalDate.now()).getYears()<18){
            return null;
        }

        return storage.create(user);
    }
    public List<User> list(){
        return storage.list();
    }

    public User edit (int id, User userUpdated){
        User userToEdit = search(id);
        if(userToEdit==null){
            return null;
        }
        return storage.edit(userToEdit,userUpdated);


    }

    public User search(int id){
        if(id>0){
            return storage.search(id);
        }
        return null;
    }
    public boolean delete (int id){
        if(id>0){
            return storage.delete(id);
        }
        return false;
    }





}

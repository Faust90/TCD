package tcd.services;

import tcd.auth.User;
import java.util.*;
import tcd.model.Character;
import tcd.model.Role;

public interface TCDServiceLocal {

    List<Character> getCharacterList(final int userId);

    List<Role> getRoleList();

    void saveCharacter();

    User doLogin();

}

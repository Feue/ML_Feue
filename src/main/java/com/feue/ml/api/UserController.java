package com.feue.ml.api;

import com.feue.ml.core.annotation.Admin;
import com.feue.ml.dto.RegisterDTO;
import com.feue.ml.entity.User;
import com.feue.ml.exception.ParameterException;
import com.feue.ml.service.UserService;
import com.feue.ml.vo.UserVO;
import com.feue.ml.vo.UnifyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Feue
 * @create 2022-04-17 14:16
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "get/by/username/{username}")
    public UnifyResponse<List<User>> getByUserName(@PathVariable String username) {
        List<User> userList = userService.findByUsername(username);
        return new UnifyResponse<>(userList, "查询成功");
    }

    @RequestMapping(method = RequestMethod.POST, value = "register")
    public UnifyResponse<UserVO> register(@RequestBody RegisterDTO dto) {
        User user = userService.findByPhone(dto.getPhone());
        if (user == null) {
            user = userService.register(dto);
        } else {
            if (!dto.getPassword().equals(user.getPassword())) {
                throw new ParameterException(20003);
            }
        }
        UserVO vo = new UserVO(user);
        return new UnifyResponse<>(vo, "登录成功");
    }

    @RequestMapping(method = RequestMethod.GET, value = "delete/by/id/{id}")
    public UnifyResponse delete(@PathVariable Long id) {
        userService.delete(id);
        return new UnifyResponse("删除成功");
    }

    @Admin
    @RequestMapping("admin")
    public UnifyResponse<String> admin() {
        return new UnifyResponse<>("访问成功");
    }
    @RequestMapping("noadmin")
    public UnifyResponse<String> noadmin() {
        return new UnifyResponse<>("访问成功");
    }
}

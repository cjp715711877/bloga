package wang.ismy.bloga.controller.ws;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wang.ismy.bloga.Result;
import wang.ismy.bloga.entity.User;
import wang.ismy.bloga.service.ws.AuthenticationService;


@RestController
@RequestMapping(value = "/ws",method = RequestMethod.GET)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/auth")
    public Result auth(@RequestParam("user") String user,
                       @RequestParam("salt") String salt,@RequestParam("sign") String sign){
        return authenticationService.auth(user,salt,sign);
    }
}

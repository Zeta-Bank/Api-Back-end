package BL3.BackEnd.user;


import BL3.BackEnd.user.dto.UserCreationDto;
import BL3.BackEnd.user.dto.UserResponseDTO;
import BL3.BackEnd.user.dto.UserUpdateDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("users")
@RestController
// isso aqui em baixo serve por ser um projeto local
@CrossOrigin(origins = "*")
@Tag(name = "EndPoint usuário", description = "Crud simples das possíveis ações do usuário no sistema.")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @Operation(summary = "Cria um novo usuário.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Usuário criado sem problemas."),
        @ApiResponse(responseCode = "400", description = "Erro ao criar usuário.")
    })
    @PostMapping
    public ResponseEntity createUser(@RequestBody UserCreationDto userDTO){
        userService.createUser(userDTO);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Retorna um DTO do usuário solicitado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha na ao realizar operação.")
    })
    @GetMapping("{idUser}")
    public ResponseEntity getUserById(
            @Parameter(description = "Id do usuário solicitado") @PathVariable int idUser){
        UserResponseDTO response = userService.getUserById(idUser);
        return ResponseEntity.ok().body(response);
    }

    @Operation(summary = "Retorna um DTO do usuário solicitado")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Operação realizada com sucesso."),
            @ApiResponse(responseCode = "400", description = "Falha na ao realizar operação.")
    })
    @GetMapping("/email/{emailUser}")
    public ResponseEntity getUserByEmail(
            @Parameter(description = "Email do usuário solicitado") @PathVariable String emailUser){
        UserResponseDTO response = userService.getUserByEmail(emailUser);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping
    public ResponseEntity updateUser(@RequestBody UserUpdateDto updateDto){
        userService.updateUser(updateDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{idUser}")
    public ResponseEntity deleteUser(@PathVariable int userId){
        userService.delete(userId);
        return ResponseEntity.ok().build();
    }

}

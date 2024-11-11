package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.misc.base.KeyValueDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agents")
@RequiredArgsConstructor
public class AgentController {

    private final ModelMapper modelMapper;
    private final AgentService agentService;

    @GetMapping
    public List<AgentDto> getAllAgents() {
        return agentService.getAllAgents()
                .stream()
                .map(agent -> modelMapper.map(agent, AgentDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/list")
    @PreAuthorize("hasAuthority('agent:view')")
    public List<KeyValueDto> getAllAgentsList() {
        return agentService.getAllAgentsList();
    }

    @GetMapping("/{id}")
    public AgentDto getAgentById(@PathVariable Long id) {
        return modelMapper.map(agentService.getAgentById(id), AgentDto.class);
    }
}

package demo.pxportfolio.realestateagency.misc.agents;

import demo.pxportfolio.realestateagency.misc.base.ListDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/agents")
@RequiredArgsConstructor
public class AgentController {

    private final AgentService agentService;

    @GetMapping
    public List<AgentDto> getAllAgents() {
        return agentService.getAllAgents();
    }

    @GetMapping("/{id}")
    public AgentDto getAgentById(@PathVariable Long id) {
        return agentService.getAgentById(id);
    }

    @GetMapping("/list")
    public List<ListDto> getAllAgentsList() {
        return agentService.getAllAgentsList();
    }
}

package nl.maxhov.repository;

import com.blazebit.persistence.CriteriaBuilder;
import com.blazebit.persistence.CriteriaBuilderFactory;
import com.blazebit.persistence.view.EntityViewManager;
import com.blazebit.persistence.view.EntityViewSetting;
import com.blazebit.persistence.view.Sorters;
import jakarta.persistence.EntityManager;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CatViewRepository {

  private final EntityManager em;
  private final CriteriaBuilderFactory cbf;
  private final EntityViewManager evm;

  public CatViewRepository(EntityManager em, CriteriaBuilderFactory cbf, EntityViewManager evm) {
    this.em = em;
    this.cbf = cbf;
    this.evm = evm;
  }

  public <T> T findById(EntityViewSetting<T, CriteriaBuilder<T>> setting, Long id) {
    return evm.find(em, setting, id);
  }

  public <T> List<T> findAll(EntityViewSetting<T, ?> setting) {
    if (setting.getAttributeSorters().isEmpty()) {
      // By default, sort on id property
      setting.withAttributeSorter("id", Sorters.ascending());
    }

    return evm.applySetting(
            setting,
            cbf.create(
                em, evm.getMetamodel().managedView(setting.getEntityViewClass()).getEntityClass()))
        .getResultList();
  }
}

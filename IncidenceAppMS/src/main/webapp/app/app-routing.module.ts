import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { errorRoute } from './layouts/error/error.route';
import { navbarRoute } from './layouts/navbar/navbar.route';
import { DEBUG_INFO_ENABLED } from 'app/app.constants';
import { Authority } from 'app/config/authority.constants';

import { UserRouteAccessService } from 'app/core/auth/user-route-access.service';
import { IncidenceModule } from './pages/incidences/incidence.module';
import { AdminRoutingModule } from './admin/admin-routing.module';
import { AccountModule } from './account/account.module';
import { LoginModule } from './login/login.module';
import { EntityRoutingModule } from './entities/entity-routing.module';

@NgModule({
  imports: [
    RouterModule.forRoot(
      [
        {
          path: 'admin',
          data: {
            authorities: [Authority.ADMIN],
          },
          canActivate: [UserRouteAccessService],
          //loadChildren: () => import('./admin/admin-routing.module').then(m => m.AdminRoutingModule),
          loadChildren: () => AdminRoutingModule,
        },
        {
          path: 'account',
          //loadChildren: () => import('./account/account.module').then(m => m.AccountModule),
          loadChildren: () => AccountModule,
        },
        {
          path: 'login',
          //loadChildren: () => import('./login/login.module').then(m => m.LoginModule),
          loadChildren: () => LoginModule,
        },
        {
          path: '',
          canActivate: [UserRouteAccessService],
          //loadChildren: () => import(`./entities/entity-routing.module`).then(m => m.EntityRoutingModule),
          loadChildren: () => EntityRoutingModule,
        },
        {
          path: 'incidences',
          canActivate: [UserRouteAccessService],
          //loadChildren: () => import(`./entities/entity-routing.module`).then(m => m.IncidenceModule),
          loadChildren: () => IncidenceModule,
        },
        navbarRoute,
        ...errorRoute,
      ],
      { enableTracing: DEBUG_INFO_ENABLED }
    ),
  ],
  exports: [RouterModule],
})
export class AppRoutingModule {}

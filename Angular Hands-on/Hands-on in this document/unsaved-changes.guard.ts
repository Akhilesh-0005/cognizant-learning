import { CanDeactivateFn } from '@angular/router';
export interface DirtyFormComponent { isDirty():boolean; }
export const unsavedChangesGuard:CanDeactivateFn<DirtyFormComponent>=(c)=>!c.isDirty()||confirm('You have unsaved changes. Leave?');
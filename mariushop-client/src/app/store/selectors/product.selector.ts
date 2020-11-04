import {AppState} from '../../product';
import {createSelector} from '@ngrx/store';
import {IProductState} from '../state/product.state';
import { from } from 'rxjs';

const selectProduct = (state: AppState) => state.productsList;

export const selectProductList = createSelector(
  selectProduct,
  (state: IProductState) => state.productsList
);

export const selectSelectedProduct = createSelector(selectProduct, (state: IProductState) => state.selectedProduct);
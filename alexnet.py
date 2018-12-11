from __future__ import absolute_import
from __future__ import division
from __future__ import print_function
import tensorflow as tf

slim = tf.contrib.slim

def alexnet(data, num_classes=1000, is_training=True, reuse=None, scope='alexnet'):
	with tf.variable_scope(scope, "Model", reuse=reuse):
		with slim.arg_scope(default_arg_scope(is_training)):
			end_points = {}
			end_point = 'conv1'
			net = slim.conv2d(data, 96, [11, 11], stride=4, scope='end_point')
			end_points[end_point] = net

			end_point = 'pool1'
			net = slim.max_pool2d(net, [3, 3],stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'conv2'
			net = slim.conv2d(net, 256, [5, 5], scope='end_point')
			end_points[end_point] = net

			end_point = 'pool2'
			net = slim.max_pool2d(net, [3, 3],stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'conv3'
			net = slim.conv2d(net, 384, [3, 3], scope='end_point')
			end_points[end_point] = net

			end_point = 'conv4'
			net = slim.conv2d(net, 384, [3, 3], scope='end_point')
			end_points[end_point] = net

			end_point = 'conv5'
			net = slim.conv2d(net, 256, [3, 3], scope='end_point')
			end_points[end_point] = net

			end_point = 'pool5'
			net = slim.max_pool2d(net, [3, 3],stride=2, scope='end_point')
			end_points[end_point] = net

			end_point = 'fc6'
			net = slim.fully_connected(net, scope=end_point)
			end_points[end_point] = net

			net = slim.dropout(net, 0.5, scope='drop6')

			end_point = 'fc7'
			net = slim.fully_connected(net, scope=end_point)
			end_points[end_point] = net

			net = slim.dropout(net, 0.5, scope='drop7')

			end_point = 'fc8'
			net = slim.fully_connected(net, scope=end_point)
			end_points[end_point] = net

			end_points['loss'] = slim.softmax(net, scope='loss')


alexnet.default_image_size = 224

# The code is applicable to any model. It is adapted from 
# https://github.com/tensorflow/models/blob/master/research/slim/nets/inception_utils.py
def default_arg_scope(is_training=True, 
                       weight_decay=0.00004,
                       use_batch_norm=True,
                       batch_norm_decay=0.9997,
                       batch_norm_epsilon=0.001,
                       batch_norm_updates_collections=tf.GraphKeys.UPDATE_OPS):

   batch_norm_params = {
      # Decay for the moving averages.
      'decay': batch_norm_decay,
      # epsilon to prevent 0s in variance.
      'epsilon': batch_norm_epsilon,
      # collection containing update_ops.
      'updates_collections': batch_norm_updates_collections,
      # use fused batch norm if possible.
      'fused': None,
   }
   if use_batch_norm:
       normalizer_fn = slim.batch_norm
       normalizer_params = batch_norm_params
   else:
       normalizer_fn = None
       normalizer_params = {}

   # Set training state 
   with slim.arg_scope([slim.batch_norm, slim.dropout],
                        is_training=is_training):
       # Set weight_decay for weights in Conv and FC layers.
       with slim.arg_scope([slim.conv2d, slim.fully_connected],
                        weights_regularizer=slim.l2_regularizer(weight_decay)):
           # Set batch norm 
           with slim.arg_scope(
           [slim.conv2d],
           normalizer_fn=normalizer_fn,
           normalizer_params=normalizer_params):
               # Set default padding and stride
               with slim.arg_scope([slim.conv2d, slim.max_pool2d],
                      stride=1, padding='SAME') as sc:
                   return sc
